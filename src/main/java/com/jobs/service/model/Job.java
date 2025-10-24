package com.jobs.service.model;

import java.util.List;

public class Job {
    private String id;
    private String title;
    private String organization;
    private String organizationUrl;
    private String location;
    private List<String> locationsDerived;
    private List<String> countriesDerived;
    private String employmentType;
    private String url;
    private boolean directApply;
    private String descriptionText;
    private String organizationLogo;
    private String source;
    private String seniority;
    private String linkedinOrgEmployees;
    private String linkedinOrgSize;
    private String linkedinOrgSlogan;
    private String linkedinOrgIndustry;
    private String linkedinOrgFollowers;
    private String linkedinOrgHeadquarters;
    private String linkedinOrgType;
    private String linkedinOrgFoundedDate;
    private String linkedinOrgDescription;
    private boolean linkedinOrgRecruitmentAgencyDerived;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getOrganization() { return organization; }
    public void setOrganization(String organization) { this.organization = organization; }

    public String getOrganizationUrl() { return organizationUrl; }
    public void setOrganizationUrl(String organizationUrl) { this.organizationUrl = organizationUrl; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public List<String> getLocationsDerived() { return locationsDerived; }
    public void setLocationsDerived(List<String> locationsDerived) { this.locationsDerived = locationsDerived; }

    public List<String> getCountriesDerived() { return countriesDerived; }
    public void setCountriesDerived(List<String> countriesDerived) { this.countriesDerived = countriesDerived; }

    public String getEmploymentType() { return employmentType; }
    public void setEmploymentType(String employmentType) { this.employmentType = employmentType; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public boolean isDirectApply() { return directApply; }
    public void setDirectApply(boolean directApply) { this.directApply = directApply; }

    public String getDescriptionText() { return descriptionText; }
    public void setDescriptionText(String descriptionText) { this.descriptionText = descriptionText; }

    public String getOrganizationLogo() { return organizationLogo; }
    public void setOrganizationLogo(String organizationLogo) { this.organizationLogo = organizationLogo; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getSeniority() { return seniority; }
    public void setSeniority(String seniority) { this.seniority = seniority; }

    public String getLinkedinOrgEmployees() { return linkedinOrgEmployees; }
    public void setLinkedinOrgEmployees(String linkedinOrgEmployees) { this.linkedinOrgEmployees = linkedinOrgEmployees; }

    public String getLinkedinOrgSize() { return linkedinOrgSize; }
    public void setLinkedinOrgSize(String linkedinOrgSize) { this.linkedinOrgSize = linkedinOrgSize; }

    public String getLinkedinOrgSlogan() { return linkedinOrgSlogan; }
    public void setLinkedinOrgSlogan(String linkedinOrgSlogan) { this.linkedinOrgSlogan = linkedinOrgSlogan; }

    public String getLinkedinOrgIndustry() { return linkedinOrgIndustry; }
    public void setLinkedinOrgIndustry(String linkedinOrgIndustry) { this.linkedinOrgIndustry = linkedinOrgIndustry; }

    public String getLinkedinOrgFollowers() { return linkedinOrgFollowers; }
    public void setLinkedinOrgFollowers(String linkedinOrgFollowers) { this.linkedinOrgFollowers = linkedinOrgFollowers; }

    public String getLinkedinOrgHeadquarters() { return linkedinOrgHeadquarters; }
    public void setLinkedinOrgHeadquarters(String linkedinOrgHeadquarters) { this.linkedinOrgHeadquarters = linkedinOrgHeadquarters; }

    public String getLinkedinOrgType() { return linkedinOrgType; }
    public void setLinkedinOrgType(String linkedinOrgType) { this.linkedinOrgType = linkedinOrgType; }

    public String getLinkedinOrgFoundedDate() { return linkedinOrgFoundedDate; }
    public void setLinkedinOrgFoundedDate(String linkedinOrgFoundedDate) { this.linkedinOrgFoundedDate = linkedinOrgFoundedDate; }

    public String getLinkedinOrgDescription() { return linkedinOrgDescription; }
    public void setLinkedinOrgDescription(String linkedinOrgDescription) { this.linkedinOrgDescription = linkedinOrgDescription; }

    public boolean isLinkedinOrgRecruitmentAgencyDerived() { return linkedinOrgRecruitmentAgencyDerived; }
    public void setLinkedinOrgRecruitmentAgencyDerived(boolean linkedinOrgRecruitmentAgencyDerived) {
        this.linkedinOrgRecruitmentAgencyDerived = linkedinOrgRecruitmentAgencyDerived;
    }
}
