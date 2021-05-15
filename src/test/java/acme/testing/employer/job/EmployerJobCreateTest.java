/*
 * EmployerJobCreateTest.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.testing.employer.job;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeJobsTest;

public class EmployerJobCreateTest extends AcmeJobsTest {

	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/employer/job/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void createPositive(final int recordIndex, final String reference, final String title, final String deadline, final String salary, final String score, final String moreInfo, final String description) {
		super.signIn("employer1", "employer1");

		super.clickOnMenu("Employer", "Create a job");

		super.fillInputBoxIn("reference", reference);
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("deadline", deadline);
		super.fillInputBoxIn("salary", salary);
		super.fillInputBoxIn("score", score);
		super.fillInputBoxIn("moreInfo", moreInfo);
		super.fillInputBoxIn("description", description);
		super.clickOnSubmitButton("Create");

		super.clickOnMenu("Employer", "List my jobs");
		
		super.checkColumnHasValue(recordIndex, 0, reference);
		super.checkColumnHasValue(recordIndex, 1, deadline);
		super.checkColumnHasValue(recordIndex, 2, title);

		super.clickOnListingRecord(recordIndex);

		super.checkInputBoxHasValue("reference", reference);
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("deadline", deadline);
		super.checkInputBoxHasValue("salary", salary);
		super.checkInputBoxHasValue("score", score);
		super.checkInputBoxHasValue("moreInfo", moreInfo);
		super.checkInputBoxHasValue("description", description);

		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/employer/job/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void createNegative(final int recordIndex, final String reference, final String title, final String deadline, final String salary, final String score, final String moreInfo, final String description) {
		super.signIn("employer3", "employer3");

		super.clickOnMenu("Employer", "Create a job");

		super.fillInputBoxIn("reference", reference);
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("deadline", deadline);
		super.fillInputBoxIn("salary", salary);
		super.fillInputBoxIn("score", score);
		super.fillInputBoxIn("moreInfo", moreInfo);
		super.fillInputBoxIn("description", description);
		super.clickOnSubmitButton("Create");

		super.checkErrorsExist();

		super.signOut();
	}

	// Ancillary methods ------------------------------------------------------

}
