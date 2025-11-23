package restfulwebservices.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import restfulwebservices.controller.IHelloWorldController;
import restfulwebservices.dto.response.HelloWorldResponseDTO;
import restfulwebservices.wrapper.ApiResponse;

@RestController
public class HelloWorldController implements IHelloWorldController {

  @Override
  public ApiResponse<HelloWorldResponseDTO> hello(@PathVariable String name) {
    HelloWorldResponseDTO response =
      new HelloWorldResponseDTO("Hello World Path Variable: " + name);

    return ApiResponse.ok("Request processed successfully", response);
  }

  @Override
  public ApiResponse<HelloWorldResponseDTO> hello2(String name) {
    HelloWorldResponseDTO response  = new HelloWorldResponseDTO(
      "Hello World by Request Param VALID ONE  "+ name
    );
    return ApiResponse.ok("Request Proceed Successfully",response);
  }

  @Override
  public ResponseEntity<ApiResponse<HelloWorldResponseDTO>> hello3(@RequestParam String name) {
    HelloWorldResponseDTO response = new HelloWorldResponseDTO("Hello World Request Param: v3 " + name);

    return ResponseEntity.ok(
      ApiResponse.<HelloWorldResponseDTO>builder()
        .success(true)
        .message("Request processed successfully")
        .data(response)
        .build()
    );
  }

}