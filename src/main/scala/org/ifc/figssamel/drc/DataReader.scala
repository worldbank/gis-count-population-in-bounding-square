package org.ifc.figssamel.drc

import util.Try

trait DataReader[T] {
  
  def readMaybe(path: String): Seq[Try[T]]

  def read(path: String): Seq[T] = readMaybe(path).flatMap(_.toOption)
  
}
