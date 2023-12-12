import styles from '@/styles/createworkspace.module.css';

const FormGuests = () => {
	return (
		<fieldset className={styles.container_form_guests}>
			<div className={styles.container_input_content}>
				<label htmlFor="guests">Invitados</label>
				<textarea
					placeholder="Invitados"
					name="guests"
					id="guests"
					className={styles.input_guests}
				></textarea>
			</div>
		</fieldset>
	);
};

export default FormGuests;
