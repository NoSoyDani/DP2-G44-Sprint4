package acme.features.manager.task;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class ManagerTaskListService implements AbstractListService<Manager, Task> {
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected ManagerTaskRepository repository;

		// AbstractListService<Manager, Task>  interface -------------------------


		@Override
		public boolean authorise(final Request<Task> request) {
			assert request != null;

			return true;
		}

		@Override
		public void unbind(final Request<Task> request, final Task entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "title", "description", "link", "startDate");
			request.unbind(entity, model, "endingDate", "workload", "finished", "privacy", "executionPeriod");
		}

		@Override
		public Collection<Task> findMany(final Request<Task> request) {
			assert request != null;

			Collection<Task> result;
			Principal principal;

			principal = request.getPrincipal();
			result = this.repository.findManyByManagerId(principal.getActiveRoleId());

			return result;
		}

}