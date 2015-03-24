package edu.gu.maze;

import edu.gu.maze.controller.ProjectController;
import edu.gu.maze.model.Project;
import edu.gu.maze.view.ProjectView;
import javax.swing.SwingUtilities;

/*
  Application entry class (if using standard java and Swing)
*/
public final class Main {
	private Main() {
		/* No instances allowed! */
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
                    final Project project = new Project();
                    final ProjectView projectView = new ProjectView(project);

                    
                    ProjectController.create(project, projectView);
                    projectView.setVisible(true);
                });
        System.out.println("Bla");
        System.out.println("Testar git");
	}
}
