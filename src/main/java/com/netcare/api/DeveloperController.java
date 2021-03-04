package com.netcare.api;


import com.netcare.customexception.CustomException;
import com.netcare.entity.Developer;
import com.netcare.mapper.DeveloperDTO;
import com.netcare.mapper.DeveloperMapper;
import com.netcare.mapper.SaveDeveloperDTO;
import com.netcare.service.DeveloperService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/developer", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class DeveloperController {

    private final DeveloperService developerService;
    private final DeveloperMapper developerMapper;

    //to do Swagger,Auth,Security,Logs..a lot of stuff can be done :)

    @RequestMapping(value = "/delete/{id}", produces = "application/json", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.GONE)
    public void deleteDeveloper(@PathVariable("id") Long id){
        developerService.deleteDeveloperByID(id);
    }

   //@Operation(summary = "Save new Developer.")  this is swagger description I didn't implement it
   @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<DeveloperDTO> saveNewDeveloper(@RequestBody SaveDeveloperDTO saveDeveloperDTO) throws CustomException {
       Developer developer = developerMapper.fromSaveOrUpdate(saveDeveloperDTO);
       DeveloperDTO developerDTO = developerMapper.toDeveloper(developerService.addDeveloper(developer));
       return new ResponseEntity<>(developerDTO, HttpStatus.OK);
   }

    @GetMapping("/all")
    public ResponseEntity<List<Developer>> getAllDevelopers(){
        List<Developer> developers = developerService.findAllDevelopers();
        return new ResponseEntity<List<Developer>>(developers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Developer> getDeveloperByID(@PathVariable("id") Long id) throws CustomException {
        Developer developer = developerService.findDeveloperByID(id);
        return new ResponseEntity<Developer>(developer, HttpStatus.OK);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDeveloper(@PathVariable("id") Long id, @RequestBody Developer developer) throws CustomException {
        Developer updatedDeveloper = developerService.updateDeveloper(developer, id);
        return new ResponseEntity<Developer>(updatedDeveloper, HttpStatus.OK);

    }


}