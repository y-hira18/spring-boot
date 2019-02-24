using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;
using SampleApp;

namespace SampleAppTest
{
    [TestClass]
    public class MethodClassTest
    {
        const string Method1Str = "str1,str2,str1";
        const string Method3Str = "str";

        [TestMethod]
        public void Method1Test()
        {
            Assert.AreEqual(Method1Str, MethodClass.Method1());
        }

        [TestMethod]
        public void Method3Test()
        {
            Mock<PropertyClass> mockPropertyClass = new Mock<PropertyClass>();
            mockPropertyClass.SetupGet(property => property.Str).Returns(Method3Str);
            Assert.AreEqual(Method3Str, mockPropertyClass.Object.Str);
        }
    }
}
