# Serverless Workflow Linter CLI

This project provides CLI Validation (both Schema and Workflow Model) for the 
Serverless Workflow Specification Version 0.1 (https://github.com/cncf/wg-serverless/blob/master/workflow/spec/spec.md)

### Getting Started

#### Building locally
To build project and run tets locally:

```
git clone https://github.com/serverless-workflow/workflow-linter-cli.git
cd workflow-linter-cli
mvn clean install
```

Then to use it in your project pom.xml add:

```xml
<dependency>
    <groupId>org.servlerless</groupId>
    <artifactId>workflow-linter-cli</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

#### Starting the Linter
To start using the linter you can run it in the workflow-linter-cli directory with:

```
cd workflow-linter-cli
mvn spring-boot:run
```

This will start the linter SpringBoot application and present you with a prompt.
You can type "help" to see the list of all available linter commands.

Currently you have to use the "validate" command to validate a serverless workflow json or yml file.
The validate command takes in a full path to a .json or a .yml file which includes your serverless workflow markup.

so for example:

```
workflow-linter >validate /Users/myuser/devel/wg/workflow-impl/src/test/resources/basic/singledelaystate.yml
```

would read the json file, validate it and then presen you with validation results.