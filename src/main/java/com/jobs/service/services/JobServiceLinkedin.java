package com.jobs.service.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobs.service.model.Job;
import org.asynchttpclient.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class JobServiceLinkedin {

    @Value("${rapidapi.key}")
    private String apiKey;

    @Value("${rapidapi.host}")
    private String apiHost;

    @Value("${rapidapi.url}")
    private String apiUrl;

    /**
     * Fetch all jobs from LinkedIn RapidAPI asynchronously
     *
     * @return List of Job objects
     */
    public List<Job> searchJobs() {
        List<Job> jobs = new ArrayList<>();
        AsyncHttpClient client = new DefaultAsyncHttpClient();

        try {
            // Make async API request
            CompletableFuture<Response> futureResponse = client.prepare("GET", apiUrl)
                    .setHeader("x-rapidapi-key", apiKey)
                    .setHeader("x-rapidapi-host", apiHost)
                    .execute()
                    .toCompletableFuture();

            String responseBody = futureResponse.thenApply(Response::getResponseBody).join();

            // Parse JSON
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseBody);

            if (root.isArray()) {
                for (JsonNode node : root) {
                    Job job = new Job();
                    job.setId(node.path("id").asText(""));
                    job.setTitle(node.path("title").asText(""));
                    job.setOrganization(node.path("organization").asText(""));
                    job.setOrganizationUrl(node.path("organization_url").asText(""));
                    job.setLocation(node.path("countries_derived").isArray() && node.path("countries_derived").size() > 0
                            ? node.path("countries_derived").get(0).asText() : "Unknown");
                    job.setCountriesDerived(node.path("countries_derived").isArray() ?
                            mapper.convertValue(node.path("countries_derived"), List.class) : null);
                    job.setLocationsDerived(node.path("locations_derived").isArray() ?
                            mapper.convertValue(node.path("locations_derived"), List.class) : null);
                    job.setEmploymentType(node.path("employment_type").isArray() && node.path("employment_type").size() > 0
                            ? node.path("employment_type").get(0).asText("Unknown") : "Unknown");
                    job.setUrl(node.path("url").asText(""));
                    job.setDirectApply(node.path("directapply").asBoolean(false));
                    job.setDescriptionText(node.path("description_text").asText(""));
                    job.setOrganizationLogo(node.path("organization_logo").asText(""));
                    job.setSource(node.path("source").asText("LinkedIn"));
                    job.setSeniority(node.path("seniority").asText(""));
                    job.setLinkedinOrgEmployees(node.path("linkedin_org_employees").asText(""));
                    job.setLinkedinOrgSize(node.path("linkedin_org_size").asText(""));
                    job.setLinkedinOrgSlogan(node.path("linkedin_org_slogan").asText(""));
                    job.setLinkedinOrgIndustry(node.path("linkedin_org_industry").asText(""));
                    job.setLinkedinOrgFollowers(node.path("linkedin_org_followers").asText(""));
                    job.setLinkedinOrgHeadquarters(node.path("linkedin_org_headquarters").asText(""));
                    job.setLinkedinOrgType(node.path("linkedin_org_type").asText(""));
                    job.setLinkedinOrgFoundedDate(node.path("linkedin_org_foundeddate").asText(""));
                    job.setLinkedinOrgDescription(node.path("linkedin_org_description").asText(""));
                    job.setLinkedinOrgRecruitmentAgencyDerived(node.path("linkedin_org_recruitment_agency_derived").asBoolean(false));

                    jobs.add(job);
                }
            }
          System.out.println(root);
        } catch (Exception e) {
            System.err.println("Error fetching jobs from LinkedIn API: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return jobs;
    }
}
