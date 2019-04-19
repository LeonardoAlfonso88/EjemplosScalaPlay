package models;

import io.ebean._
import com.typesafe.config.Config;
import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.ManyToMany
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.CascadeType
import scala.collection.JavaConverters._


@Entity
case class User() extends Model 
{
    //Atributos
    @Id
    @Column(name="idUser")
      private var _id : Long = 0

    @Column(name="nombre",length = 50, nullable = false)
      private var _nombre : String = ""

    @Column(name="edad", nullable = true)
      private var _age : Int = _

    var find : Finder[Long, User] = new Finder[Long, User](classOf[User])

    //Relaciones
    @OneToMany(mappedBy="user")
      private var _books : List[Book] = List[Book]()

    //Getters y Settes
      def id = _id
      def nombre = _nombre
      def age = _age

      def id_(id : Long) = _id = id
      def nombre_(nombre : String) = _nombre = nombre
      def age_(age: Int) = _age = age

    //Queries

      // Retorna la relación uno a muchos
      def books() : List[Book] = 
      {
          var resultBooks : Option[List[Book]] = Some(Book().find.query().where()
                                                       .eq("user_id_user", this.id)
                                                       .findList()
                                                       .asScala.toList)
          _books = resultBooks match 
          {
              case Some(s) => s
              case None => List[Book]()
          }
          
          return _books
      }

      // Retorna todos los usuarios disponibles
      def all() : List[User] = find.all().asScala.toList

      // Sobreescritura save para salvar relaciones
      override def save() : Unit = 
      {
          super.save()
          var booksRelation : Option[List[Book]] = Some(_books)
          booksRelation match
          {
              case Some(s) =>
              {
                  var it : Iterator[Book] = s.iterator
                  var actualBook : Book = Book()

                  while(it.hasNext)
                  {
                      actualBook = it.next()
                      actualBook.user = this
                      actualBook.save()
                  }
              }
              case None => ""
          }
      }

      // Agregar un elemento a la relación
      def addBook(book : Option[Book]) : Unit =
      {
          book match
          {
              case Some(s) => 
              {
                  var newBooks : List[Book] = List(s)
                  _books = _books ::: newBooks
              }
              case None => ""
          }
      }

      // Agregar un listado de elementos a la relación
      def addBooks(books : Option[List[Book]]) : Unit = 
      { 
          books match
          {
              case Some(s) => 
              {
                 _books = _books ::: s
              }
              case None => ""
          }
      }
}
