package lk.ijse.gdse71.back_end.impl;

import lk.ijse.gdse71.back_end.dto.JobDto;

import java.util.List;
import java.util.Map;

public interface JObService {
     void saveJob(JobDto jobDto);
     void updateJob( JobDto jobDto);
     List<JobDto> getAllJob();
     void changeJobStatus(String id);
     List<JobDto> searchJob(String input);
     String getJobDescription(String id);
     void deteleJob(String id);
     List<Map> getPage(int page, int size);
}
