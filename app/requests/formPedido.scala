package requests

import viewModels._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._

object pedidoForm
{
    val pedido: Form[Pedido] = Form(
    // Defines a mapping that will handle Contact values
        mapping(
          "idUsuario" -> longNumber,
          "tipoPago" -> number.verifying(min(0), max(3)),
          "idDireccion" -> number,
          // Defines a repeated mapping
          "productos" -> list(
            mapping(
              "idProducto" -> longNumber,
              "cantidad" -> number
            )(Producto.apply)(Producto.unapply)
          )
        )(Pedido.apply)(Pedido.unapply)
    )
}
