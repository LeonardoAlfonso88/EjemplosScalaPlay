package viewModels

case class Pedido(
    idUsuario : Long,
    tipoPago : Int,
    idDireccion : Int,
    productos : List[Producto]
)
