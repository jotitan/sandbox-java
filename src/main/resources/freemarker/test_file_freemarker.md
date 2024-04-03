# ${movie.title()} (${movie.year()})

## Réalisateur : ${movie.director()}

Acteurs

<#list movie.actors() as actor>
* ${actor}
</#list>

![img](https://avatars.githubusercontent.com/u/1869588?v=4)