# Java DropWizard Flyway Starter

Database Migration - Local
---

1. Add your SQL script to `resources.db.migration` directory
2. Add the following lines to your ~/.zshrc file:

```
export FLYWAY_URL="jdbc:mysql://YOUR_DB_HOST/YOUR_DB_NAME"
export FLYWAY_USER="YOUR_DB_USERNAME"
export FLYWAY_PASSWORD="YOUR_DB_PASSWORD"
export FLYWAY_BASELINE_ON_MIGRATE=true
```

3. Reload your terminal session if required:

```
. ~/.zshrc
```

4. Run Flyway command through Maven:

```
mvn flyway:migrate
```

Database Migration - Production
---

1. Add following secrets to your Github repo:

```
DB_USERNAME - the prod db username
DB_PASSWORD - the prod db password
DB_HOST - the prod db host
DB_NAME - the prod db name
```

2. Raise a pull request with your script in the `resources.db.migration` directory
3. After approvals, merge pull request; this will trigger the migration action to run in Github
4. Ensure migration successfully runs against prod database

How to start the test application
---

1. Set the following environment variables:
    1. DB_USERNAME
    2. DB_PASSWORD
    3. DB_HOST
    4. DB_NAME
2. Run `mvn clean install` to build your application
3. You can start application via IDE: Edit run configuration -> Add `server` to program arguments -> Run
4. To check that your application is running enter url `http://localhost:8080/api/test`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

**How to Lint**
---

Configure checkstyle in Intellij:
1. Open Settings,
2. Go to Tools, then Checkstyle,
3. Under Configuration File, click Add,
4. Type 'Sun Checks Modified' in the Description,
5. Click Browse, then go to src/main/resources/sun_checks_modified,
6. Click Next, then Next again, then Finish,
7. Check the box for Active, then click Apply, then OK,
8. Click on the CheckStyle button above the Terminal button and select Sun Checks Modified as the Rules.

**How to run Integration Tests**
---

1. Open the .zshrc file
2. Add the following lines to your ~/.zshrc file:

```
export "VALID_TEST_EMAIL"="user@email.com"
export "VALID_TEST_PASSWORD"="regularU\$er123"
 
```

3. Reload your terminal session if required:

```
. ~/.zshrc
```

4. Reload IntelliJ if required
