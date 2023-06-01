package home.nikolabojanic.sprint.support;
import home.nikolabojanic.sprint.model.User;
import home.nikolabojanic.sprint.web.dto.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
@Component
public class UserToUserDto implements Converter<User, UserDto>{
	@Override
	public UserDto convert(User source) {
		UserDto target = new UserDto();
		target.setId(source.getId());
		target.setUsername(source.getUsername());
		return target;
	}
}