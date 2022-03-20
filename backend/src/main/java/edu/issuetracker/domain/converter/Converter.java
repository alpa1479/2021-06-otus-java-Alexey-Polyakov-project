package edu.issuetracker.domain.converter;

import edu.issuetracker.domain.viewmodel.PageViewModel;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.apache.commons.collections4.CollectionUtils.isEmpty;
import static org.apache.commons.collections4.ListUtils.emptyIfNull;

public interface Converter<IN, OUT> {

    OUT convert(IN source);

    default List<OUT> convert(Collection<IN> source) {
        return isEmpty(source) ? emptyList() : source.stream().map(this::convert).toList();
    }

    default PageViewModel<OUT> convert(Page<IN> source) {
        if (source == null) {
            return PageViewModel.empty();
        }
        List<IN> content = emptyIfNull(source.getContent());
        return new PageViewModel<>(content.stream().map(this::convert).toList(), source.getTotalElements());
    }
}
