package com.andytech.notebook.controllers;


import com.andytech.notebook.services.NotebookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Andres Toledo on 10/02/22
 *
 * This class is used to handle the requests for sorting algorithms.
 */
@RestController
public class NotebookController {

    Logger logger = LoggerFactory.getLogger(NotebookController.class);

    //Sorting Service
    @Autowired
    private NotebookService notebookService;


    @GetMapping("/test")
    public ResponseEntity<String> test()
    {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
//    /**
//     * This method is used to handle the request for the selection sort algorithm.
//     *
//     * @param listToSort The list of integers to sort
//     * @param order The order to sort the list in (asc or desc)
//     * @param steps Whether to return the steps of the algorithm.
//     * @return The response of the sorting algorithm
//     */
//    @PostMapping("/sorting/selection")
//    public ResponseEntity<SortingResponse<Integer>> selectionSort(@RequestBody ArrayList<Integer>listToSort, @RequestParam(name="order",required = false,defaultValue = "asc") String order, @RequestParam(name="steps",defaultValue ="false")boolean steps)
//    {
//        logger.info("Input values: "+ listToSort.toString());
//        return new ResponseEntity<>(sortingService.selectionSort(listToSort,order,steps), HttpStatus.OK);
//    }
}
