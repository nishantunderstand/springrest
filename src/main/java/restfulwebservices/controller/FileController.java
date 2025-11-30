package restfulwebservices.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import restfulwebservices.dto.request.FileUploadRequestDTO;
import restfulwebservices.dto.request.MultipleFileUploadRequestDTO;
import restfulwebservices.dto.response.FileUploadResponseDTO;
import restfulwebservices.wrapper.ApiPageAbleResponse;
import restfulwebservices.wrapper.ApiResponse;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileController {

    @Value("${file.upload-dir}")
    private String uploadDir;

    // ---------------------------------------------------------------------
    // 1️⃣ Single File Upload
    // ---------------------------------------------------------------------
    @PostMapping("/upload")
    public ApiResponse<FileUploadResponseDTO> upload(@ModelAttribute FileUploadRequestDTO request) throws Exception {

        MultipartFile file = request.getFile();
        Path dir = Paths.get(uploadDir).toAbsolutePath().normalize();
        Files.createDirectories(dir);

        Path filePath = dir.resolve(file.getOriginalFilename());
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        FileUploadResponseDTO response = FileUploadResponseDTO.builder()
                .filename(file.getOriginalFilename())
                .size(file.getSize())
                .url("/files/download/" + file.getOriginalFilename())
                .build();

        return ApiResponse.ok("File uploaded successfully", response);
    }

    // ---------------------------------------------------------------------
    // 2️⃣ Multiple File Upload
    // ---------------------------------------------------------------------
    @PostMapping("/upload-multiple")
    public ApiResponse<List<FileUploadResponseDTO>> uploadMultiple(
            @ModelAttribute MultipleFileUploadRequestDTO request) throws Exception {

        Path dir = Paths.get(uploadDir).toAbsolutePath().normalize();
        Files.createDirectories(dir);

        List<FileUploadResponseDTO> uploaded = new ArrayList<>();

        for (MultipartFile file : request.getFiles()) {

            Path filePath = dir.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            uploaded.add(FileUploadResponseDTO.builder()
                    .filename(file.getOriginalFilename())
                    .size(file.getSize())
                    .url("/files/download/" + file.getOriginalFilename())
                    .build());
        }

        return ApiResponse.ok("Files uploaded successfully", uploaded);
    }

    // ---------------------------------------------------------------------
    // 3️⃣ File Download
    // ---------------------------------------------------------------------
    @GetMapping("/download/{name}")
    public ResponseEntity<Resource> download(@PathVariable String name) throws Exception {

        Path filePath = Paths.get(uploadDir).resolve(name).normalize();
        Resource resource = new UrlResource(filePath.toUri());

        if (!resource.exists()) {
            throw new RuntimeException("File not found: " + name);
        }

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + name)
                .body(resource);
    }

    // Utility: List All File Names
    private List<String> listAllFiles() throws Exception {
        Path dir = Paths.get(uploadDir).toAbsolutePath().normalize();
        Files.createDirectories(dir);

        return Files.list(dir)
                .map(p -> p.getFileName().toString())
                .sorted()
                .collect(Collectors.toList());
    }

    // ---------------------------------------------------------------------
    // 4️⃣ Offset Pagination (Page + Size)
    // ---------------------------------------------------------------------
    @GetMapping("/list-offset")
    public ApiPageAbleResponse<String> listOffset(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) throws Exception {

        List<String> allFiles = listAllFiles();
        int total = allFiles.size();

        int fromIndex = Math.min((page - 1) * size, total);
        int toIndex = Math.min(fromIndex + size, total);

        List<String> result = allFiles.subList(fromIndex, toIndex);

        return ApiPageAbleResponse.offset(
                "Files fetched successfully",
                result,
                page,
                size,
                total
        );
    }

    // ---------------------------------------------------------------------
    // 5️⃣ Keyset Pagination (Cursor Based)
    // ---------------------------------------------------------------------
    @GetMapping("/list-keyset")
    public ApiPageAbleResponse<String> listKeyset(
            @RequestParam(required = false) String after,
            @RequestParam(defaultValue = "10") int size) throws Exception {

        List<String> allFiles = listAllFiles();
        List<String> result;

        if (after == null) {
            result = allFiles.stream().limit(size).collect(Collectors.toList());
        } else {
            result = allFiles.stream()
                    .dropWhile(name -> !name.equals(after))
                    .skip(1)
                    .limit(size)
                    .collect(Collectors.toList());
        }

        String nextCursor = result.isEmpty() ? null : result.get(result.size() - 1);
        boolean hasNext = nextCursor != null &&
                allFiles.indexOf(nextCursor) < allFiles.size() - 1;

        return ApiPageAbleResponse.keyset(
                "Files fetched successfully",
                result,
                nextCursor,
                hasNext
        );
    }

    // ---------------------------------------------------------------------
    // 6️⃣ Infinite Scroll Pagination (Offset-like but no page info)
    // ---------------------------------------------------------------------
    @GetMapping("/list-infinite")
    public ApiPageAbleResponse<String> listInfinite(
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "10") int limit) throws Exception {

        List<String> allFiles = listAllFiles();

        List<String> result = allFiles.stream()
                .skip(offset)
                .limit(limit)
                .collect(Collectors.toList());

        boolean hasNext = offset + limit < allFiles.size();

        return ApiPageAbleResponse.keyset(
                "Files fetched successfully",
                result,
                String.valueOf(offset + limit),
                hasNext
        );
    }
}
