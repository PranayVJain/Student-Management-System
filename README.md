# StudentManagementSystem

## Requirement
1. Admin should be able to insert records containing student info.
2. A Student should check his rank and score
3. Institutes should get the range of student with ranks from 1-10


## Assumptions
### Functional Assumptions
1. Authentications and authorization are already handled.
2. The APIs are well published and documented.
3. The CI/CD process is already set to publish the helm charts and the docker image.
4. The ranks of all the students will be generated after entering all the student details.
5. The subjects are pre-defined.
6. Memory is limited as in mem cache is used.
7. Student names are unique
8. Max marks that can be obtained from a subject = 50.
9. RBAC is already in place.

### Non functional Assumptions
1. The service is highly available.
2. Prometheus server captures the metrics and publishes the report to monitor the application.
3. Liveness and Readiness probe are in place.
4. Pod wil scale up based on the load using K8s Scaled objects.