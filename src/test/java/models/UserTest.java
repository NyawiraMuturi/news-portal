package models;

import org.junit.*;

import static org.junit.Assert.*;

public class UserTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void departmentInstantiatesCorrectly_true() throws Exception {
        User newUser = setUpnewUser();
        assertEquals(true, newUser instanceof User);
    }

    @Test
    public void  getNameReturnsNameCorrectly_String() throws Exception {
        User newUser = setUpnewUser();
        assertEquals("Nyawira", newUser.getName());
    }
    @Test
    public void getPositionReturnsPositionCorrectly_String() throws Exception {
        User newUser = setUpnewUser();
        assertEquals("Cashier", newUser.getPosition());
    }
    @Test
    public void  getRoleReturnsRoleCorrectly_String() throws Exception {
        User newUser = setUpnewUser();
        assertEquals("Book keeping", newUser.getRole());
    }
    @Test
    public void  getIdDeptreturnsIdDeptCorrectly_Int() throws Exception {
        User newUser = setUpnewUser();
        assertEquals("4", newUser.getIddept());
    }
    @Test
    public void setNameSetsCorrectName() throws Exception {
        User newUser = setUpnewUser();
        newUser.setName("Jackson Gale");
        assertEquals("Jackson Gale", newUser.getName());
    }
    @Test
    public void setPositionSetsCorrectPosition() throws  Exception {
        User newUser = setUpnewUser();
        newUser.setPosition("Cashier");
        assertEquals("Cashier", newUser.getPosition());
    }
    @Test
    public void setRoleSetsCorrectRole() throws Exception {
        User newUser = setUpnewUser();
        newUser.setRole("Research Manager");
        assertEquals("Research Manager", newUser.getRole());
    }
    @Test
    public void setSectionIdSetsCorrectSectionId() throws Exception {
        User newUser = setUpnewUser();
        newUser.setIddept("4");
        assertEquals("4", newUser.getIddept());
    }
    @Test
    public void departmentReturnsTrueIfNameAndDetailsAndTotalEmployeesAreSame() throws Exception {
        User newUser = setUpnewUser();
        User otherUser = setUpnewUser();
        assertEquals(true, newUser.equals(otherUser));
    }

    public User setUpnewUser(){
        return new User("Nyawira", "Cashier","Book Keeping", "4");
    }

}