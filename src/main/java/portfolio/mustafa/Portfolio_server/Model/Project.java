package portfolio.mustafa.Portfolio_server.Model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@Entity
@Table(name = "projects") // Table name in the database
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate IDs in PostgreSQL
    private Long id; // Changed to Long for auto-generation of IDs (or use UUID if preferred)

    @Column(name = "img_src")  // Column names are explicitly specified (optional)
    private String imgSrc;

    private String title;
    private String description;

    @JsonProperty("GitHubLink")
    @Column(name = "github_link")  // Specify column name for clarity (optional)
    private String gitHubLink;

    @Column(name = "live_link")  // Specify column name for clarity (optional)
    private String liveLink;

    @ElementCollection // This annotation is used for a collection of simple types
    @CollectionTable(name = "project_tech_stack", joinColumns = @JoinColumn(name = "project_id"))
    @Column(name = "tech_stack")
    private List<String> techStack; // New field to store technology stack

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(String id) {
        this.id = Long.valueOf(id);
    }

    // Getter and Setter for imgSrc
    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for GitHubLink
    public String getGitHubLink() {
        return gitHubLink;
    }

    public void setGitHubLink(String gitHubLink) {
        this.gitHubLink = gitHubLink;
    }

    // Getter and Setter for liveLink
    public String getLiveLink() {
        return liveLink;
    }

    public void setLiveLink(String liveLink) {
        this.liveLink = liveLink;
    }

    // Getter and Setter for techStack
    public List<String> getTechStack() {
        return techStack;
    }

    public void setTechStack(List<String> techStack) {
        this.techStack = techStack;
    }
}
