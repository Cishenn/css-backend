package com.cishenn.ccs.controller;

import com.cishenn.ccs.biz.IServicerBiz;
import com.cishenn.ccs.entity.Servicer;
import com.cishenn.ccs.uitls.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/servicer")
@CrossOrigin
public class ServicerController {
    @Autowired
    IServicerBiz iServicerBiz;

    @PostMapping("/login")
    public Result login(@RequestBody Servicer servicer){
        Servicer loginServicer = iServicerBiz.login(servicer);
        if(loginServicer!=null){
            return Result.ok(loginServicer);
        }else{
            return Result.error("通过不了->LoginCtrl中没有获得biz的返回值");
        }
    }

    @PostMapping("/register")
    public Result save(@RequestBody Servicer servicer){
        iServicerBiz.save(servicer);
        return Result.ok("注册成功啦~~");
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        iServicerBiz.delete(id);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id,@RequestBody Servicer servicer){
        iServicerBiz.update(id,servicer);
        return Result.ok("更新成功");
    }

    @GetMapping("/{id}")
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
