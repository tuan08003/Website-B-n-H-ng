package tuanngpd08863.java6.rest.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.websocket.server.PathParam;
import tuanngpd08863.java6.service.UploadService;

@CrossOrigin("*")
@RestController
public class UploadRestController {
	@Autowired
	UploadService uploadServices;
	
	@PostMapping("/rest/upload/{folder}")
	public JsonNode upload(@PathParam("file") MultipartFile file,
			@PathVariable("folder") String folder) {
	File savedFile = uploadServices.save(file, folder);
	
	ObjectMapper mapper = new ObjectMapper();
	ObjectNode node = mapper.createObjectNode();
	node.put("name", savedFile.getName());
	node.put("size", savedFile.length());
	return node;
	}
}
