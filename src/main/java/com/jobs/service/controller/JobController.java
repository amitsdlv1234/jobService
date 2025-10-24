package com.jobs.service.controller;

import com.jobs.service.model.Job;
import com.jobs.service.services.JobServiceLinkedin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobServiceLinkedin jobService;

    // Redirect /jobs to default source
    @GetMapping
    public String redirectToDefaultSource() {
        return "redirect:/jobs/linkedin";
    }

    // Home page: show job sources
    @GetMapping("/")
    public String home(Model model) {
        List<Map<String, String>> sources = List.of(
                Map.of(
                        "id", "linkedin",
                        "name", "LinkedIn",
                        "logo", "https://cdn-icons-png.flaticon.com/512/174/174857.png"
                )
        );
        model.addAttribute("sources", sources);
        return "home";
    }

    // Job list page: fetch jobs filtered by source using RESTful path
    @GetMapping("/{source}")
    public String listJobs(@PathVariable String source, Model model) {
        List<Job> allJobs = jobService.searchJobs();
        List<Job> jobs = allJobs.stream()
                .filter(job -> source.equalsIgnoreCase(job.getSource()))
                .collect(Collectors.toList());

        model.addAttribute("jobs", jobs);
        model.addAttribute("source", source);
        return "jobs";
    }

    // Job details page: fetch job by ID using RESTful path
    @GetMapping("/{source}/{id}")
    public String jobDetails(@PathVariable String source, @PathVariable String id, Model model) {
        List<Job> allJobs = jobService.searchJobs();
        Job selectedJob = allJobs.stream()
                .filter(job -> job.getId().equals(id) && source.equalsIgnoreCase(job.getSource()))
                .findFirst()
                .orElse(null);

        if (selectedJob == null) {
            return "redirect:/jobs/" + source; // fallback if job not found
        }

        model.addAttribute("job", selectedJob);
        return "job-details";
    }

    // --------- JSON API Endpoints ---------

    @GetMapping(value = "/api/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Job> apiGetAllJobs() {
        return jobService.searchJobs();
    }

    @GetMapping(value = "/api/by-source", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Job> apiGetJobsBySource(@RequestParam String source) {
        return jobService.searchJobs().stream()
                .filter(job -> source.equalsIgnoreCase(job.getSource()))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/api/details", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Job apiGetJobDetails(@RequestParam String url) {
        return jobService.searchJobs().stream()
                .filter(job -> job.getUrl().equals(url))
                .findFirst()
                .orElse(null);
    }
}
