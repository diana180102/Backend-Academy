package org.example.code.academy.service.Implement;

import lombok.RequiredArgsConstructor;
import org.example.code.academy.model.Register;
import org.example.code.academy.model.RegisterDetails;
import org.example.code.academy.repository.IGenericRepo;
import org.example.code.academy.repository.IRegisterRepo;
import org.example.code.academy.service.IRegisterService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;


@Service
@RequiredArgsConstructor
public class RegisterServiceImple extends CRUDImpl<Register, Integer> implements IRegisterService {


    private final IRegisterRepo repo;

    @Override
    protected IGenericRepo<Register, Integer> getRepo() {
        return repo;
    }




    @Override
    public Map<String, Long> getCourseCountStudent() {

        Stream<Register> register = repo.findAll().stream();
        Stream<List<RegisterDetails>>  detailsStream = register.map(Register::getRegisterDetails);
        Stream<RegisterDetails> detail = detailsStream.flatMap(Collection::stream);

        Map<String, Long> byCourse = detail.collect(groupingBy(r -> r.getCourse().getName(),counting()));



         return byCourse;
    }

    @Override
    public Map<Object, List<String>> getCourseNameStudent() {

        Stream<Register> register = repo.findAll().stream();
        Stream<List<RegisterDetails>>  detailsStream = register.map(Register::getRegisterDetails);
        Stream<RegisterDetails> detail = detailsStream.flatMap(Collection::stream);

       Map<Object, List<String>> byCourse = detail.collect(groupingBy(
               r -> r.getCourse().getName(),
               mapping( c -> c.getRegister().getStudent().getName(), toList())
       ));

    return byCourse;
    }
}
