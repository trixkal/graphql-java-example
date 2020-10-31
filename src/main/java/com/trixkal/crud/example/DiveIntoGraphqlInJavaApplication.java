package com.trixkal.crud.example;

//import com.coxautodev.graphql.tools.SchemaParser;
import graphql.kickstart.servlet.SimpleGraphQLHttpServlet;
import graphql.kickstart.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
//import graphql.servlet.SimpleGraphQLHttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import com.trixkal.crud.example.resolver.Mutation;
import com.trixkal.crud.example.service.AttendeeService;
import com.trixkal.crud.example.resolver.Query;
import com.trixkal.crud.example.resolver.TalkReslover;
import com.trixkal.crud.example.service.SpeakerService;
import com.trixkal.crud.example.service.TalkService;

@SpringBootApplication
public class DiveIntoGraphqlInJavaApplication {


	@Autowired
	private SpeakerService speakerService;

	@Autowired
	private TalkService talkService;

	@Autowired
	private AttendeeService attendeeService;

	public static void main(String[] args) {
		SpringApplication.run(DiveIntoGraphqlInJavaApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean graphQLServlet() {
//		GraphQLEntryPoint graphQLEntryPoint = new GraphQLEntryPoint(speakerService,attendeeService,talkService);

		return new ServletRegistrationBean(SimpleGraphQLHttpServlet.newBuilder(buildSchema(speakerService,attendeeService,talkService)).build(),"/graphql");
	}




	private static GraphQLSchema buildSchema(SpeakerService speakerService, AttendeeService attendeeService, TalkService talkService) {
		return SchemaParser
				.newParser()
				.file("graphql/schema.graphqls")
//                .dictionary()
				.resolvers( new Query(attendeeService,speakerService,talkService),
						new TalkReslover(speakerService),
						new Mutation(speakerService))
				.build()
				.makeExecutableSchema();
	}



}
