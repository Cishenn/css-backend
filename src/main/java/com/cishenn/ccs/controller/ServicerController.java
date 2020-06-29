package com.cishenn.ccs.controller;

import com.cishenn.ccs.biz.IServicerBiz;
import com.cishenn.ccs.entity.Servicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/servicer")
public class ServicerController {
    @Autowired
    IServicerBiz iServicerBiz;

    @PostMapping("/")
    void save(@RequestBody Servicer servicer){
        iServicerBiz.save(servicer);
    }

    @DeleteMapping("/")
    void delete(@PathVariable Integer id){
        iServicerBiz.delete(id);
    }

    @PutMapping("/")
    void update(@PathVariable Integer id,@RequestBody Servicer servicer){
        iServicerBiz.update(id,servicer);
    }

    @GetMapping("/")
    ResponseEntity<Servicer> getOne(@PathVariable Integer id){
        return new ResponseEntity<>(iServicerBiz.getOne(id), HttpStatus.OK);
    }

    @GetMapping("/")
    ResponseEntity<Map<String,List<Servicer>>> getAll(){
        Map<String, List<Servicer>> result=new HashMap();
        result.put("servicers",iServicerBiz.getAll());
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
