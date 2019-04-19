package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import models._
//import viewModels._
import requests._
import play.filters.cors.CORSFilter
import play.api.http.{ DefaultHttpFilters, EnabledFilters }
import play.api.libs.json.Json
import javax.persistence._
import io.ebean
import io.ebean._
import play.data.format._
import play.data.validation._
import scala.collection.JavaConverters._
import play.api.Logger

import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  // def index() = Action 
  // { 
  //   implicit request: Request[AnyContent] =>

  //      var user : User = User()
  //      var book1 : Book = Book()
  //      var book2 : Book = Book()
  //      var book3 : Book = null
  //      var books = List[Book]()

  //      user.nombre_("Leonardo")
  //      user.age_(31)
  //      book1.title_("DC")
  //      book1.author_("Dante")
  //      book2.title_("Marvel")
  //      book2.author_("Kratos")
  //      user.addBooks(Option(books))
  //      //user.addBook(Option(book3))
  //      user.save()
        
        
  //     // //Ok(views.html.index(user._books))
  //     // user.save()
  //     Ok("user")
  // }

  // def test() = Action
  // {
  //   implicit request: Request[AnyContent] =>

  //     //var user = User().find.query().where().eq("nombre", "Leonardo").findOne()
  //   //   var users = User().all();

  //   //var book = Book().find.query().where().eq("idBook", "5").findOne();
  //   //   //Ok(user.books())
  //   //  //Ok(views.html.index(user.books()))
  //   //  //Ok(views.html.index(users))
  //     System.out.println(request)
  //    Ok("Hola")

  // }

    def postTest() = Action
    {
      implicit request: Request[AnyContent] =>
          pedidoForm.pedido.bindFromRequest.fold(
              formWithErrors => {
                BadRequest("no")
              },
              pedido => {
                  var service : servicioVerificacion() = servicioVerificacion()
                  var response : Boolean = service.verificarClienteExistente(pedido)

                  if (response)
                  {
                    Ok("Ok")
                  }
                  else
                  {
                    Ok("NOk")
                  }
              }
          )
  }
}
