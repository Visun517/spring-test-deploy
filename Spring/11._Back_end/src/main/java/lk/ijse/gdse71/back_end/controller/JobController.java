package lk.ijse.gdse71.back_end.controller;

import jakarta.validation.Valid;
import lk.ijse.gdse71.back_end.dto.JobDto;
import lk.ijse.gdse71.back_end.impl.JObService;
import lk.ijse.gdse71.back_end.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("api/v1/job")
@RestController
@RequiredArgsConstructor
@CrossOrigin ///---> Cross-Origin Resource Sharing (CORS) allows restricted resources on a web page to be requested from another domain outside the domain from which the first resource was served.
@Slf4j //---> Lombok's @Slf4j annotation is used to create a logger instance for the class, which can be used to log messages at different levels (info, debug, error, etc.)
public class JobController {

    private final JObService jobService;

    @PostMapping("create")
    public ResponseEntity<ApiResponse> createJob(@Valid @RequestBody JobDto jobDto) {
        log.info("INFO Creating a new job with details: {}", jobDto);
        log.warn("WARN Job creation endpoint hit with job details: {}", jobDto);
//        log.error("ERROR Job creation endpoint hit with job details: {}", jobDto);
        log.trace("TRACE Job creation endpoint hit with job details: {}", jobDto);
        log.debug("DEBUG Job creation endpoint hit with job details: {}", jobDto);
        jobService.saveJob(jobDto);
        return ResponseEntity.ok( new ApiResponse(200, "save success", null));

    }

    @PutMapping("update")
    public ResponseEntity<ApiResponse> updateJob(@RequestBody JobDto jobDto) {
        // Logic to update a Job
        jobService.updateJob(jobDto);
        return ResponseEntity.ok( new ApiResponse(200, "update success",null));
    }

    @GetMapping("get")
    public ResponseEntity<ApiResponse> getAllJob(){
        List<JobDto> allJob = jobService.getAllJob();
        return ResponseEntity.ok(
                new ApiResponse(200, "All Jobs get successfully", allJob)
        );
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PatchMapping("status/{id}")
    public ResponseEntity<ApiResponse> changeStatus(@PathVariable String id){
        jobService.changeJobStatus(id);
        return ResponseEntity.ok(
                new ApiResponse(200, "Job status changed successfully", null)
        );
    }

    @GetMapping("search/{Keyword}")
    public ResponseEntity<ApiResponse> searchJob(@PathVariable String Keyword) {
        List<JobDto> jobDtos = jobService.searchJob(Keyword);
        return ResponseEntity.ok(
                new ApiResponse(200, "Search results for '" + Keyword + "'", jobDtos)
        );
    }

    @GetMapping("getDesc/{id}")
    public ResponseEntity<ApiResponse> getJobDescription(@PathVariable String id) {
        String jobDescription = jobService.getJobDescription(id);
        return ResponseEntity.ok(
                new ApiResponse(200, "Job description retrieved successfully", jobDescription)
        );
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ApiResponse> jobDelete(@PathVariable String id){
        jobService.deteleJob(id);
        return ResponseEntity.ok(
                new ApiResponse(200, "Job deleted successfully", null)
        );
    }

    @GetMapping("getPage")
    public ResponseEntity<ApiResponse> getPage(@RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "10") int size) {


        List<Map> page1 = jobService.getPage(page, size);
        return ResponseEntity.ok(
                new ApiResponse(200, "Page retrieved successfully", page1)
        );


    }
}
