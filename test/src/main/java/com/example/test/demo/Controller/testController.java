package com.example.test.demo.Controller;


import com.example.test.demo.Model.testModel;
import com.example.test.demo.Repository.testRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/test/api")
public class testController {

    @Autowired
    private testRepo TR;

    @PostMapping("/add")
    @ResponseBody
    public testModel add(@RequestBody testModel tm)
    {
        TR.save(tm);
        return tm;
    }

    @PostMapping("/ad")
    @ResponseBody
    public String addurl(@RequestParam Integer tID,@RequestParam String tName)
    {
        testModel t = new testModel();
        t.settID(tID);
        t.settName(tName);
        TR.save(t);
        return "Response : Successfully Added";
    }


    @GetMapping("/view")
    @ResponseBody
    public Iterable<testModel> view()
    {
        return TR.findAll();
    }

    @GetMapping("/view/{tID}")
    @ResponseBody
    public testModel viewID(@PathVariable Integer tID)
    {
        Optional<testModel> OPT = TR.findById(tID);
        return OPT.get();

    }

    @DeleteMapping("delete/{tID}")
    @ResponseBody
    public String deleteID(@PathVariable Integer tID)
    {
        TR.deleteById(tID);
        return"{Response : Deleted }";


    }


    @PutMapping("edit/{tID}")
    @ResponseBody
    public ResponseEntity<Object> edit(@RequestBody testModel TMO,@PathVariable Integer tID) {
        Optional<testModel> OT = TR.findById(tID);
        if (!OT.isPresent())
            return ResponseEntity.notFound().build();
        TMO.settID(tID);
        TR.save(TMO);
        return ResponseEntity.noContent().build();
    }


    }





