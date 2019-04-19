package models;

import io.ebean._
import javax.persistence.Entity
import com.typesafe.config.Config

/**
 * Created by azeem on 4/30/2017.
 */
@Entity
case class Target() extends Model 
{
    //Atributos
      private var _id: Long = 0
      private var _code : Int = 1

    //Getters y Settes
      def id = _id
      def code = _code

      def id_(id : Long) = _id = id
      def code_(code : Int) = _code = code

}