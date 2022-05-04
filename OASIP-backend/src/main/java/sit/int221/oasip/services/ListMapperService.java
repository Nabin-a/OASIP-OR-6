package sit.int221.oasip.services;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ListMapperService {
    private static final ListMapperService listMapper = new ListMapperService();

    private ListMapperService() {
    }

    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass, ModelMapper modelMapper) {
        return source.stream().map(entity -> modelMapper.map(entity, targetClass)).
                collect(Collectors.toList());
    }
    public static ListMapperService getInstance() {
        return listMapper;
    }
}
