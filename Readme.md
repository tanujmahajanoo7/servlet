# Servlet Projects

This directory contains various Java servlet projects demonstrating different concepts and patterns.

## Projects Overview

- **FirstProject** - Basic servlet greeting application
- **SecondProject** - Servlet page sending example
- **GETPOST** - Demonstrates GET and POST request handling with login functionality
- **getresult** - Result fetching servlet with database integration
- **MVCArchitecture** - Model-View-Controller architecture implementation
- **ServletChaining** - Demonstrates servlet chaining between FirstServlet and SecondServlet
- **ServletLifeCycle** - Explains servlet lifecycle methods

## Setup Instructions

### Steps to Prepare Eclipse for Servlet Projects

1. Open Eclipse
2. Change perspective:
   - Go to **Window** → **Perspective** → **Open perspective** → **Other**
   - Select **JavaEE**

   > [!TIP]
   > You can also use the icon in the top right corner to quickly change perspective

3. Add JAR files to Tomcat server:
   - Copy servlet-related JAR files to:
   ```
   C:\Program Files\Apache Software Foundation\Tomcat 9.0\lib
   ```

## Additional Notes

- Each project contains its own `src/main/java` directory with servlet classes
- Web application configuration files (`web.xml`) are located in `src/main/webapp/WEB-INF/`
- Compiled classes are available in the `build/classes` directory
