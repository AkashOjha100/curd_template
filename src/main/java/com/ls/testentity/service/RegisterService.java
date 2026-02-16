package com.ls.testentity.service;

import com.ls.testentity.entity.Register;
import com.ls.testentity.model.RegisterRequestDto;
import com.ls.testentity.model.RegisterResponseDto;
import com.ls.testentity.repository.RegisterRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RegisterService {

    private final RegisterRepository registerRepository;
    private final PasswordEncoder passwordEncoder;
    //private final ModelMapper modelMapper;


    //CREATE ALL REGISTER
    public List<RegisterResponseDto> AddRegister(List<RegisterRequestDto> registerRequestDto){
        int count=0;
        List<Register> registers = new ArrayList<>();
        for(RegisterRequestDto dto : registerRequestDto) {
            //for(registers registers:registers)
            Register register = Register.builder()
                    .name(dto.getName())
                    .username(dto.getUsername())
                    .password(passwordEncoder.encode(dto.getPassword()))
                    .email(dto.getEmail())
                    .phone_no(dto.getPhone_no())
                    .build();
            registers.add(register);
            count++;
            //Register saved = registerRepository.save(register);
        }
        List<Register> savedRegister=registerRepository.saveAll(registers);

        List<RegisterResponseDto>responseList =new ArrayList<>();
        for(Register register:savedRegister){
            RegisterResponseDto responseDto=new RegisterResponseDto(
                    register.getId(),
                    register.getName(),
                    register.getUsername(),
                    register.getEmail(),
                    register.getPhone_no()
            );
            responseList.add(responseDto);
        }
        return responseList;
    }

    //---->GET ALL DETAILS<-------
    public List<RegisterResponseDto> getRegisterDetails(){
        List<Register> registers=registerRepository.findByDeletedFalse();
        return registers
                .stream()
                .map(this::convertToResponseDto)
                .toList();
        //return RegisterResponseDtos;
    }

    //------->GET DETAIL USING ID<--------
    public RegisterResponseDto getDetailsByid(Long id){
        Register register=registerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Register Not found by this id :"+id));
        return convertToResponseDto(register);
    }

    private RegisterResponseDto convertToResponseDto(Register register){
        RegisterResponseDto responseDto=new RegisterResponseDto();
        responseDto.setId(register.getId());
        responseDto.setName(register.getName());
        responseDto.setUsername(register.getUsername());
        responseDto.setEmail(register.getEmail());
        responseDto.setPhone_no(register.getPhone_no());
        return responseDto;
    }

    //------->UPDATE BY ID<-----------
    public RegisterResponseDto updateRegister(Long id, RegisterRequestDto requestDto){
        Register register=registerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Register details not found in this id :"+id));

        register.setName(requestDto.getName());
        register.setUsername(requestDto.getUsername());
        register.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        register.setEmail(requestDto.getEmail());
        register.setPhone_no(requestDto.getPhone_no());

        Register updatedRegister=registerRepository.save(register);

        return convertToResponseDto(updatedRegister);
    }

    public void deleteById(Long id){
        registerRepository.deleteById(id);
    }
}
