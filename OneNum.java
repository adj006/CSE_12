/**
 *  An interface specification for a simple integer container ADT.
 *  An instance of this ADT is a container for one nonnegative integer.
 *  A mutator (setter) method and an accessor (getter) method are provided.
 *  In addition, an implementation of this interface should provide
 *  a default constructor that initializes the integer to 0.
 */
public interface OneNum {

  /** Set the contained integer to the given value.
   *  PRECONDITION: the given value is not negative
   *  POSTCONDITION: the contained integer is set to the given value.
   *  @param num The given value.
   *  @throw IllegalArgumentException if the given value is negative.
   */
  public void setNum(int num);

  /** Return the value of the contained integer.
   *  PRECONDITION: none
   *  POSTCONDITION: the contained integer is not changed.
   *  @return The current value of the contained integer.
   */
  public int getNum();

}
