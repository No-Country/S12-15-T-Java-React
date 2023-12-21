import stylesRegister from '@/styles/register.module.css';

const Logo = () => {
	return (
		<img
			src="/images/logo-Track.png"
			className={stylesRegister.logo}
			alt="track-logo"
		/>
	);
};

export default Logo;
