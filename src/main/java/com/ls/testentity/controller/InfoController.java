package com.ls.testentity.controller;

import com.ls.testentity.model.InfoRequestDto;
import com.ls.testentity.model.InfoResponseDto;
import com.ls.testentity.service.InfoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/info")
public class InfoController {

    private final InfoService infoService;

    @GetMapping
    public ResponseEntity<List<InfoResponseDto>> getAllInformation(){
        return ResponseEntity.ok(infoService.getAllInformation());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InfoResponseDto> getInformationById(@PathVariable Long id){
        return ResponseEntity.ok(infoService.getInformationById(id));
    }

    @PostMapping
    public ResponseEntity<InfoResponseDto> addNewInformation(@RequestBody @Valid InfoRequestDto infoRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(infoService.AddNewInformation(infoRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInformation(@PathVariable Long id) {
        infoService.remove(id);
        return ResponseEntity.ok("Information soft deleted successfully 😊");
    }

    @PutMapping("/{id}")
    public InfoResponseDto updateInformation(@PathVariable Long id,@RequestBody InfoRequestDto infoRequestDto){
        return infoService.updateInformationById(id,infoRequestDto);
    }

}
