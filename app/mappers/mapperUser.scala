package mappers

import viewModels._
import models._

class mapperUser(userVM : userVM)
{
    //Atributos
    var user : User = _
    var userVM : userVM = userVM

    def mapper() : User = 
    {
        this.user.nombre = userVM.nombre
        user.creacion = date(today)
        mapperBooks()
        this.user.save()
        return user
    }

    private def mapperBooks =
    {

    }
}