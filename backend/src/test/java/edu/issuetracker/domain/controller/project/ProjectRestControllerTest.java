package edu.issuetracker.domain.controller.project;

import edu.issuetracker.domain.converter.Converter;
import edu.issuetracker.domain.model.project.Project;
import edu.issuetracker.domain.service.project.ProjectService;
import edu.issuetracker.domain.viewmodel.project.ProjectTableElementViewModel;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.test.web.servlet.MockMvc;

import static edu.issuetracker.domain.controller.project.PageableAssert.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(
        controllers = ProjectRestController.class,
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = WebSecurityConfigurer.class)},
        excludeAutoConfiguration = {SecurityAutoConfiguration.class, SecurityFilterAutoConfiguration.class,
                OAuth2ClientAutoConfiguration.class, OAuth2ResourceServerAutoConfiguration.class})
class ProjectRestControllerTest {

    @MockBean
    private ProjectService projectService;

    @MockBean
    private Converter<Project, ProjectTableElementViewModel> projectToProjectTableElementConverter;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCheckThatSortingAndPagingParametersWorks() throws Exception {
        mockMvc.perform(get("/api/projects")
                        .param("page", "5")
                        .param("size", "10")
                        .param("sort", "title,asc")
                        .param("sort", "created_date,desc"))
                .andExpect(status().isOk());

        ArgumentCaptor<Pageable> pageableCaptor = ArgumentCaptor.forClass(Pageable.class);
        verify(projectService).getProjectsPage(pageableCaptor.capture(), eq(null));

        PageRequest pageable = (PageRequest) pageableCaptor.getValue();

        assertThat(pageable)
                .hasPageNumber(5)
                .hasPageSize(10)
                .hasSort("title", Sort.Direction.ASC)
                .hasSort("created_date", Sort.Direction.DESC);
    }
}
