import Banner from '@/components/Landing/Banner';
import Banner2 from '@/components/Landing/Banner2';
import LandNav from '@/components/Landing/LandNav';

export const LandingPage = () => {
	return (
		<div>
			<LandNav />
			<Banner />
			<Banner2 />
		</div>
	);
};
export default LandingPage;
