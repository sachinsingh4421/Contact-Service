package portfolio.mustafa.Portfolio_server.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.mustafa.Portfolio_server.Model.Project;
import portfolio.mustafa.Portfolio_server.Repository.ProjectRepo;
import portfolio.mustafa.Portfolio_server.Exception.ResourceNotFoundException;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepository;

    // Create or Update Project
    public Project saveProject(Project project) {
        validateProject(project);
        return projectRepository.save(project);
    }

    // Get All Projects
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // Get Project by ID
    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Project not found with ID: " + id));
    }

    // Delete Project by ID
    public void deleteProject(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new ResourceNotFoundException("Project not found with ID: " + id);
        }
        projectRepository.deleteById(id);
    }

    // Delete All Projects
    public void deleteAllProjects() {
        projectRepository.deleteAll();
    }

    private void validateProject(Project project) {
        if (project == null || project.getTitle() == null || project.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Project title is required");
        }
        if (project.getDescription() == null || project.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Project description is required");
        }
    }
}
