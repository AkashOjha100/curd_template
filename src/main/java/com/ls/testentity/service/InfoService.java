package com.ls.testentity.service;


import com.ls.testentity.entity.Info;
import com.ls.testentity.model.InfoRequestDto;
import com.ls.testentity.model.InfoResponseDto;
import com.ls.testentity.repository.InfoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
@Component
public class InfoService {

    private final InfoRepository infoRepository;
    private final ModelMapper modelMapper;
    //private final Info info;

    //GET ALL DATA(get)
    public List<InfoResponseDto> getAllInformation(){
        List<Info> information=infoRepository.findByDeletedFalse();
        return information
                .stream()
                .map(info -> modelMapper.map(info, InfoResponseDto.class))
                .toList();
    }
    //GET BY ID
    public InfoResponseDto getInformationById(Long id){
        Info info=infoRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("Information not found in this id :"+id));
        return modelMapper.map(info,InfoResponseDto.class);
    }

    //ADD NEW DATA(post)
    public InfoResponseDto AddNewInformation(InfoRequestDto infoRequestDto){
        Info newinfo=modelMapper.map(infoRequestDto,Info.class);
        Info info=infoRepository.save(newinfo);
        return modelMapper.map(info,InfoResponseDto.class);
    }

    //UPDATE INFORMATION
    public InfoResponseDto updateInformationById(Long id ,InfoRequestDto infoRequestDto){
        Info info=infoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Information details Not found by this id :"+id));
        modelMapper.map(infoRequestDto,info);
        info=infoRepository.save(info);
        return modelMapper.map(info,InfoResponseDto.class);

    }

    //SOFT DELETE ACCESS BY ID
    public void remove(Long id){
        infoRepository.deleteById(id);
    }
}
