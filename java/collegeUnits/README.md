## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


Compile:
mkdir -p bin
javac -d bin src/unit2/*.java

Copy resource so it's on the runtime classpath:
mkdir -p bin/unit2
cp src/unit2/backgound.jpg bin/unit2/

Run:
java -cp bin unit2.MyImage

## Run JSP/Servlet on Apache Tomcat

### Run JSP (quick, no compile)
1. Install Tomcat and set CATALINA_HOME.
2. Create a webapp directory and preserve package folders:
   mkdir -p $CATALINA_HOME/webapps/collegeUnits/unit4
3. Copy JSP(s) from this project:
   cp src/unit4/bsd.jsp $CATALINA_HOME/webapps/collegeUnits/unit4/bsd.jsp
4. Start Tomcat:
   $CATALINA_HOME/bin/startup.sh
5. Open in browser:
   http://localhost:8080/collegeUnits/unit4/bsd.jsp

### Run servlet (compile + deploy)
1. Compile servlet against Jakarta Servlet API (adjust path to your servlet-api jar):
   javac -cp /path/to/jakarta.servlet-api.jar -d build src/unit4/bsd.java
2. Place compiled classes under WEB-INF/classes (preserve package):
   mkdir -p $CATALINA_HOME/webapps/collegeUnits/WEB-INF/classes
   cp -r build/unit4 $CATALINA_HOME/webapps/collegeUnits/WEB-INF/classes/
3. If required, put Jakarta servlet JARs into WEB-INF/lib (Tomcat usually provides them).
4. Restart Tomcat and open the same URL (servlet mapping is /bsd).
