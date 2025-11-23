package restfulwebservices.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import restfulwebservices.dto.response.HelloWorldResponseDTO;
import restfulwebservices.wrapper.ApiResponse;

//@RequestMapping("/v1")
public interface IHelloWorldController {

  @GetMapping("/hello-world/path-variable/{name}")
  ApiResponse<HelloWorldResponseDTO> hello(@PathVariable String name);

  @GetMapping("/hello-world/request-param")
  ApiResponse<HelloWorldResponseDTO> hello2(@RequestParam String name);

  @GetMapping("/hello-world/request-param-1")
  ResponseEntity<ApiResponse<HelloWorldResponseDTO>> hello3(@RequestParam String name);


  //@GetMapping("/request-param-2")
  //ResponseEntity<ApiResponse<HelloWorldResponseDTO>>

}