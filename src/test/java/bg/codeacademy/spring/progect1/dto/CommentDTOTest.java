package bg.codeacademy.spring.progect1.dto;

import bg.codeacademy.spring.project1.dto.CommentDTO;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class CommentDTOTest
{
  private static ValidatorFactory validatorFactory;
  private static Validator        validator;

  @BeforeClass
  public static void createValidator()
  {
    validatorFactory = Validation.buildDefaultValidatorFactory();
    validator = validatorFactory.getValidator();
  }

  @AfterClass
  public static void close()
  {
    validatorFactory.close();
  }

  @Test
  public void testCommentNull()
  {
    CommentDTO commentDTO = new CommentDTO();
    commentDTO.setUserName(null);
    commentDTO.setContent(null);
    Set<ConstraintViolation<CommentDTO>> violations = validator.validate(commentDTO);
    Assert.assertFalse(violations.isEmpty());
    Assert.assertEquals(violations.size(), 2);
  }

  @Test
  public void testCommentInvalid()
  {
    CommentDTO commentDTO = new CommentDTO();
    commentDTO.setUserName("d");
    commentDTO.setContent("a");
    Set<ConstraintViolation<CommentDTO>> violations = validator.validate(commentDTO);
    Assert.assertFalse(violations.isEmpty());
    Assert.assertEquals(violations.size(), 2);
  }
}
