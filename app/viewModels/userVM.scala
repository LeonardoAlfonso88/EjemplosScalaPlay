package viewModels

case class userVM(
    idUsuario : Long,
    nombre : String,
    edad : Int,
    books : List[bookVM]
)