restmock
========

REST service mock implemented in Java.

The server runs using embedded Jetty on 8080 port. It accepts a single argument pointing to a root of a directory tree.
The server handles incoming requsts by searching a subdirectory in the directory tree according the request URI. In the subdirectory it finds a file with JSON that is returned as result. The name of the file must conform to the HTTP method used (GET.json, POST.json, PUT.json or DELETE.json).

Example:
<pre>
run "java -jar restmock-0.1.0-SNAPSHOT.jar "/home/bob/json" 
open "http://localhost:8080/user/123"
the content of "/home/bob/json/user/123/GET.json" is returned (or 404 if the file does not exist)
</pre>
