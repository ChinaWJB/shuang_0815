import java.util.Random

import scala.util.control.Breaks

object Lottery {
  def result(x :Int) :Unit = x match {
    case 0 => println("���ź���û���н�")
    case 1 => println("��ϲ�������ߵȽ�")
    case 2 => println("��ϲ���������Ƚ�")
    case 3 => println("��ϲ��������Ƚ�")
    case 4 => println("��ϲ�������ĵȽ�")
    case 5 => println("��ϲ���������Ƚ�")
    case 6 => println("��ϲ�����˶��Ƚ�")
    case 7 => println("��ϲ������һ�Ƚ�")
  }
  def choseNum(): Array[Int] = {
    val lottery = new Array[Int](7)
    var i = 0
    val loop = new Breaks
    while(i < lottery.length) {
      var buyNum = readInt()
       if(buyNum > 0 && buyNum < 36){
         lottery(i) = buyNum
         loop.breakable{
           for(j <- 0 to i-1){
             if(lottery(i) == lottery(j)){
               println("���������ظ�����������")
               i-=1
               loop.break()
             }
           }
         }
         i+=1
       }
      else{
         println("������涨��Χ�ڵ�����")
         i-=1
       }
    }
    lottery
  }
  def ranNum(): Array[Int] = {
    var result = new Array[Int](7)
    for(i <- 0 until result.length){
      val randomNum = (new Random).nextInt(36)+1
      if(!result.exists(num => num == randomNum))
        result(i) = randomNum
    }
    result.foreach(println)
    result
  }
  def matchCount(chose: Array[Int],result: Array[Int]) : Int = {
    var count = 0
    for(i <- 0 until chose.length){
        if(result.contains(chose(i)))
          count+=1
    }
    count
  }
  def main(args: Array[String]): Unit = {

    println("��ӭʹ�ò�Ʊϵͳ")
    println("��������ѡ��ĺ���1-35֮��")
    var cho = choseNum()
    var ran = ranNum()
    result(matchCount(cho,ran))
  }

}
