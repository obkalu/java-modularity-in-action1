To compile this multi-module Java10 app using the JDK10 compiler on the command line, use the following steps:

1. Compile the independent library module by executing:

c:\oak\MyLearning\java\java10\java10apps\helloworld>javac -d bin\modules\com.obinna.java10app.libs.arithops 
							src\com.obinna.java10app.libs.arithops\module-info.java src\com.obinna.java10app.libs.arithops\com\obinna\java10app\libs\arithops\ArithOps.java

2. Compile the dependent module by executing:

c:\oak\MyLearning\java\java10\java10apps\helloworld>javac -d bin\modules\com.obinna.java10app.helloworld --module-path 
						bin\modules src\com.obinna.java10app.helloworld\module-info.java src\com.obinna.java10app.helloworld\com\obinna\java10app\helloworld\HelloWorldJava10App.java

3. Run the app by executing:

c:\oak\MyLearning\java\java10\java10apps\helloworld>java --module-path bin\modules -m 
						com.obinna.java10app.helloworld/com.obinna.java10app.helloworld.HelloWorldJava10App

4. To package the app's modules into a deployable/runnable modular jar(s):

	4.1 c:\oak\MyLearning\java\java10\java10apps\helloworld>jar --create --file=dist\com.obinna.java10app.libs.arithops@1.0.jar 
									--module-version=1.0 -C bin\modules\com.obinna.java10app.libs.arithops .
	
	4.2 c:\oak\MyLearning\java\java10\java10apps\helloworld>jar --create --file=dist\com.obinna.java10app.helloworld.jar 
		--main-class com.obinna.java10app.helloworld.HelloWorldJava10App -C bin\modules\com.obinna.java10app.helloworld .

5. To run the packaged jar(s):

	c:\oak\MyLearning\java\java10\java10apps\helloworld>java --module-path dist -m com.obinna.java10app.helloworld

	or

	c:\oak\MyLearning\java\java10\java10apps\helloworld>java -p dist -m com.obinna.java10app.helloworld

6. Inspect a packaged jar's module(s):

	c:\oak\MyLearning\java\java10\java10apps\helloworld>jar --describe-module 
													--file=dist\com.obinna.java10app.libs.arithops@1.0.jar

7. Use the linker tool, jlink, to link the set of modules, along with their transitive dependences, to create a custom modular run-time image (in other words, it creates a custom, minimal jre just sufficient enough, to run the modular app):

The following command creates a run-time image that contains the main module, com.obinna.java10app.helloworld, and its transitive dependences:

c:\oak\MyLearning\java\java10\java10apps\helloworld>jlink --module-path %JAVA_HOME%\jmods;dist --limit-modules 
		com.obinna.java10app.helloworld --add-modules com.obinna.java10app.helloworld --launcher 
		hello=com.obinna.java10app.helloworld --compress 2 --no-header-files --strip-debug --output helloworldjava10appjre

8. To run the minimal, custom jre packaged app, we execute the following:

c:\oak\MyLearning\java\java10\java10apps\helloworld>helloworldjava10appjre\bin\hello

And voila!