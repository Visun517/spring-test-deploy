package lk.ijse.gdse71.back_end.Service;

import lk.ijse.gdse71.back_end.dto.JobDto;
import lk.ijse.gdse71.back_end.entity.Job;
import lk.ijse.gdse71.back_end.exception.ResourceNoteFoundException;
import lk.ijse.gdse71.back_end.exception.UserAlreadyExist;
import lk.ijse.gdse71.back_end.impl.JObService;
import lk.ijse.gdse71.back_end.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JObService {

    private final JobRepository jobRepository;
    private final ModelMapper modelMapper;

    public void saveJob(JobDto jobDto) {
        // Logic to save the Job
//        if (jobRepository.existsById(jobDto.getId())){ throw  new UserAlreadyExist("Job with ID " + jobDto.getId() + " already exists.");}
        jobRepository.save(modelMapper.map(jobDto, lk.ijse.gdse71.back_end.entity.Job.class));

    }

    @Override
    public void updateJob(JobDto jobDto) {
        if (!jobRepository.existsById(jobDto.getId())){throw new ResourceNoteFoundException("Job with ID " + jobDto.getId() + " not found.");}
        jobRepository.save(modelMapper.map(jobDto, lk.ijse.gdse71.back_end.entity.Job.class));

    }

    @Override
    public List<JobDto> getAllJob() {
        List<Job> all = jobRepository.findAll();
        List<JobDto> jobDto = all.stream().map(job -> modelMapper.map(job, JobDto.class)).toList();

        if (jobDto.isEmpty()) {
           throw new ResourceNoteFoundException("Job not found");
        }
//        throw new ResourceNoteFoundException("Job not found");
        return jobDto;

    }

    @Override
    public void changeJobStatus(String id) {
        if (!jobRepository.existsById(Integer.valueOf(id))){throw new ResourceNoteFoundException("Job with ID " + id + " not found.");}
        jobRepository.updateJobStatus(id);
    }

    @Override
    public List<JobDto> searchJob(String input) {
        List<Job> jobs = jobRepository.findJobByJobTitleContainingIgnoreCase(input);
        if (jobs.isEmpty()) {
            throw new ResourceNoteFoundException("No jobs found with the title containing: " + input);
        }
        return jobs.stream()
                .map(job -> modelMapper.map(job, JobDto.class))
                .toList();
    }

    @Override
    public String getJobDescription(String id) {
        if (!jobRepository.existsById(Integer.valueOf(id))){throw new ResourceNoteFoundException("Job with ID " + id + " not found.");}
        Optional<Job> job = jobRepository.findById(Integer.valueOf(id));
        return job.get().getJobDescription();
    }

    @Override
    public void deteleJob(String id) {
        if (!jobRepository.existsById(Integer.valueOf(id))){throw new ResourceNoteFoundException("Job with ID " + id + " not found.");}
        jobRepository.deleteById(Integer.valueOf(id));
    }

    @Override
    public List<Map> getPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Job> pageJob = jobRepository.findAll(pageable);

        if (pageJob.isEmpty()) {
            throw new ResourceNoteFoundException("No jobs found on this page.");
        }
        List<Map> result = new ArrayList<>();
        for (Job job : pageJob) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", job.getId());
            map.put("company", job.getCompany());
            map.put("job_title", job.getJobTitle());
            map.put("location", job.getLocation());
            map.put("type", job.getType());
            result.add(map);
        }
        return result;
    }
}
