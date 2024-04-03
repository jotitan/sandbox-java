<html>
<head>
    <meta charset="UTF-8"/>
</head>
<body>
<h1>Génération de PDF avec Freemarker</h1>
<h2>${movie.title()} (${movie.year()})</h2>
<div>
    Réalisateur : <span style="font-weight:bold">${movie.director()}</span>
    <div style="float:right">
        <img style="width:150px" src="https://avatars.githubusercontent.com/u/1869588?v=4"/>
    </div>
</div>
<div>
    Acteurs :
    <ul>
        <#list movie.actors() as actor><li>${actor}</li></#list>
    </ul>
</div>
</body>
</html>