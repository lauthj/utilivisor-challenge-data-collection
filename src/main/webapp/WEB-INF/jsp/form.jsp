<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Data collection challenge - utiliVisor</title>
    </head>
    <body>
        <h1>Data collection form</h1>
        <form action="/data-collection" method="POST" enctype="multipart/form-data">
            <div>
                <label>File</label>
                <input type="file" name="file" />
            </div>
            <div>
                <input type="submit" value="Submit" />
            </div>
        </form>
    </body>
</html>